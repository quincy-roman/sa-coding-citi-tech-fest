export interface Assignment {
  id: string;
  batchId: string;
  name: string;
  maxScore: number;
  type: 'QUIZ' | 'ASSESSMENT' | 'PRACTICAL';
  dueDate: Date;
  s3FilePath?: string;
}

export interface Attendance {
  id: string;
  batchId: string;
  userId: string;
  date: Date;
  attendanceStatus: 'PRESENT' | 'LATE' | 'ABSENT';
}

export interface Batch {
  id: string;
  name: string;
  facilitatorId: string;
}

export interface Event {
  eventId: string;
  batchId: string;
  name: string;
  description: string;
  date: Date;
}

export interface Submission {
  id: string;
  userId: string;
  assignmentId: string;
  s3FilePath?: string;
  grade: number;
  submittedDate: Date;
}

export interface User {
  id: string;
  email: string;
  password: string;
  firstName: string;
  lastName: string;
  role: 'ADMIN' | 'FACILITATOR' | 'LEARNER' | 'UNASSIGNED' | 'UNVERIFIED';
  batchId?: string;
}
