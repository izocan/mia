import { Injectable } from '@angular/core';
// @ts-ignore
import { Project } from '../../../api/restAPI';
import { Observable, of } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {
  public API = 'http://localhost:8080';
  public BEER_API = this.API + '/projects';

  httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };

  constructor(private http: HttpClient) {
  }

  getProjects(): Observable<Project[]> {
    return this.http.get<Project[]>(this.API + '/get-projects')
      .pipe(
        tap(_ => console.log('Projects fetched!')),
        catchError(this.handleError<Project[]>('Get Projects', []))
      );
  }

  getProject(id: any): Observable<Project[]> {
    return this.http.get<Project[]>(this.API + '/get-project/' + id)
      .pipe(
        tap(_ => console.log('Project fetched: ${id}')),
        catchError(this.handleError<Project[]>('Get Project id=${id}', []))
      );
  }

  updateProject(id: any, project: Project): Observable<any> {
    return this.http.put(this.API + '/update-project/' + id, project, this.httpOptions)
      .pipe(
        tap(_ => console.log('Project updated: ${id}')),
        catchError(this.handleError<Project[]>('Update Project, id= ${id}'))
      );
  }


  addProject(project: Project): Observable<any> {
    return this.http.post<Project>(this.API + '/add-project', project, this.httpOptions)
      .pipe(
        catchError(this.handleError<Project>('Add Project'))
      );
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      console.log(`${operation} failed: ${error.message}`);
      return of(result as T);
    };
  }
}
