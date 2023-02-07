import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class GroupService {

  private baseUrl = 'http://localhost:8080/api/';

  constructor(private http: HttpClient) {}

  getGroup(id: number): Observable<Object> {
    return this.http.get(`${this.baseUrl}/group/${id}`);
  }

  getGroupList(): Observable<any> {
    return this.http.get(`${this.baseUrl}` + 'group-list');
  }
}
