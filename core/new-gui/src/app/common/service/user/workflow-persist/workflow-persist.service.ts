import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AppSettings } from '../../../app-setting';
import { WorkflowInfo, Workflow } from '../../../type/workflow';
import { Observable } from 'rxjs/Observable';
import { map } from 'rxjs/operators';
import { jsonCast } from '../../../util/storage';

export const WORKFLOW_URL = 'user/dictionary/validate';

@Injectable({
  providedIn: 'root'
})

export class WorkflowPersistService {

  constructor(public http: HttpClient) {
  }

  public persistWorkflow(cachedWorkflow: Workflow, workflowName: string, workflowID: number | null): Observable<Workflow> {
    const formData: FormData = new FormData();
    // TODO: change to use CacheWorkflowService.

    if (workflowID != null) {
      formData.append('wfId', workflowID.toString());
    }
    formData.append('name', workflowName);
    formData.append('content', JSON.stringify(cachedWorkflow.content));

    return this.http.post<Workflow>(`${AppSettings.getApiEndpoint()}/workflow/save-workflow`, formData);
  }

  public getWorkflow(workflowID: string): Observable<Workflow> {
    return this.http.get<Workflow>(`${AppSettings.getApiEndpoint()}/workflow/get/${workflowID}`).pipe(map(this.parseWorkflowInfo));
  }

  public getSavedWorkflows(): Observable<Workflow[]> {
    return this.http.get<Workflow[]>(
      `${AppSettings.getApiEndpoint()}/workflow/get`).pipe(map((workflows: Workflow[]) => workflows.map(this.parseWorkflowInfo)));
  }


  public deleteSavedWorkflow(deleteProject: Workflow) {
    return null;
  }

  private parseWorkflowInfo(workflow: Workflow) {
    if (typeof workflow.content === 'string') {
      workflow.content = jsonCast<WorkflowInfo>(workflow.content);
    }
    return workflow;
  }
}
