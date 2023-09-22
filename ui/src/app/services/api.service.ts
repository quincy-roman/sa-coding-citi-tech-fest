import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RegisterationInfo } from '../interfaces/types';

/** SUPER WIP, WAITING ON FINALIZED ENDPOINTS */
declare var API_URL: string;
@Injectable({
  providedIn: 'root',
})
export class ApiService {
  private url = API_URL;
  private apiUrl = this.url + '/api';
  private learnerUrl = this.apiUrl + '/learner';
  private facilitatorUrl = this.apiUrl + '/facilitator';

  constructor(private client: HttpClient) {}

  // ********************** Security Endpoints ********************** //

  login = (userInfo: { email: string; password: string }) => {
    return this.client.post(`${this.url}/login`, userInfo);
  };

  registerUser = (userInfo: {
    email: string;
    password: string;
    firstName: string;
    lastName: string;
  }) => {
    return this.client.post(`${this.url}/register`, userInfo);
  };

  /**
   * Used for when user clicks on email verification link.
   * @param userInfo
   * @returns
   */
  verifyUser = (userInfo: { email: string; token: string }) => {
    return this.client.post(`${this.url}/verify`, userInfo);
  };

  changePassword = (password: string) => {
    return this.client.post(`${this.url}/changePassword`, password);
  };

  // ********************** General Methods ********************** //

  /** Get Grades specific to the individual ID can be used for learner and facilitator*/
  getLearnerGrades = (learnerId: string) => {};

  /** Form S3 */
  getFiles = (fileId: String) => {};
  /** File Meta Data */
  getFileMeta = (fileId: String) => {};

  /** To S3 Bucket */
  uploadFile = (file: File | Blob, fileName?: string) => {
    const formData = new FormData();
    formData.append(fileName ?? (file as File).name ?? 'untitled', file);
    return this.client.post(`${this.apiUrl}/submitFile`, formData);
  };

  // ********************** Learner Specific Methods ********************** //

  /** Get Assignments specific to the individual ID */
  getAssignments = (learnerId: string) => {
    return this.client.get(`${this.apiUrl}/submitFile`, {
      params: { id: learnerId },
    });
  };

  // ********************** Facilitator Specific Methods ********************** //

  /** Get Batches of Students associated with a teacher */
  getBatches = (facilitatorId: string) => {
    return this.client.get(`${this.facilitatorUrl}/batches`, {
      params: { id: facilitatorId },
    });
  };

  /** Get All Assignments for All Batches for a teacher*/
  getAllAssignments = (facilitatorId: string) => {
    return this.client.get(`${this.facilitatorUrl}/assignments`, {
      params: { id: facilitatorId },
    });
  };

  /** Get All grades of all student with for all batches associated with a teacher */
  getAllGrades = (facilitatorId: string) => {
    return this.client.get(`${this.facilitatorUrl}/grades`, {
      params: { id: facilitatorId },
    });
  };

  postGrade = (params: {
    assignmentId: string;
    score: number;
    learnerID: string;
  }) => {
    return this.client.post(`${this.facilitatorUrl}/grades`, params);
  };

  putGrade = (params: {
    assignmentId: string;
    score: number;
    learnerID: string;
  }) => {
    return this.client.put(`${this.facilitatorUrl}/grades`, params);
  };

  /** Add one or multiple Assignments */
  addAssignment = (params: {
    maxScore: number;
    type: string;
    batchIds: string[];
    dueDate?: Date;
  }) => {
    return this.client.post(`${this.facilitatorUrl}/assignments`, params);
  };
}
