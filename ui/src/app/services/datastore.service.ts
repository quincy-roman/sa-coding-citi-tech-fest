import { Injectable } from '@angular/core';
import { ApiService } from './api.service';
import { Assignment, Batch, CalEvent, User } from '../interfaces/apiDataTypes';

@Injectable({
  providedIn: 'root',
})
export class DatastoreService {
  constructor(private api: ApiService) {}

  /** Student Data*/
  public myAssignments: Assignment[] = [];
  public myBatch: Batch = {
    id: '',
    name: '',
    facilitatorId: '',
  };
  public myGrade: number | undefined;

  /**  Facilitator Data  */
  public myLearners: User[] = [];
  public myBatches: Batch[] = [];

  /** All Users */
  public events: CalEvent[] = [];
  // combines events and Assignments
}
