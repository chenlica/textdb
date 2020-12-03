import { ValidationWorkflowService } from '../service/validation/validation-workflow.service';
import { ExecuteWorkflowService } from '../service/execute-workflow/execute-workflow.service';
import { DragDropService } from '../service/drag-drop/drag-drop.service';
import { WorkflowUtilService } from '../service/workflow-graph/util/workflow-util.service';
import { WorkflowActionService } from '../service/workflow-graph/model/workflow-action.service';
import { UndoRedoService } from '../service/undo-redo/undo-redo.service';
import { Component, OnInit } from '@angular/core';
import { OperatorMetadataService } from '../service/operator-metadata/operator-metadata.service';
import { JointUIService } from '../service/joint-ui/joint-ui.service';
import { DynamicSchemaService } from '../service/dynamic-schema/dynamic-schema.service';
import { SourceTablesService } from '../service/dynamic-schema/source-tables/source-tables.service';
import { SchemaPropagationService } from '../service/dynamic-schema/schema-propagation/schema-propagation.service';
import { ResultPanelToggleService } from '../service/result-panel-toggle/result-panel-toggle.service';
import { WorkflowCacheService } from '../service/cache-workflow/workflow-cache.service';
import { WorkflowStatusService } from '../service/workflow-status/workflow-status.service';
import { WorkflowWebsocketService } from '../service/workflow-websocket/workflow-websocket.service';
import { ActivatedRoute } from '@angular/router';
import { WorkflowPersistService } from '../../common/service/user/workflow-persist/workflow-persist.service';
import { Workflow } from '../../common/type/workflow';
import { environment } from '../../../environments/environment';

@Component({
  selector: 'texera-workspace',
  templateUrl: './workspace.component.html',
  styleUrls: ['./workspace.component.scss'],
  providers: [
    // uncomment this line for manual testing without opening backend server
    // { provide: OperatorMetadataService, useClass: StubOperatorMetadataService },
    OperatorMetadataService,
    DynamicSchemaService,
    SourceTablesService,
    SchemaPropagationService,
    JointUIService,
    WorkflowActionService,
    WorkflowUtilService,
    DragDropService,
    ExecuteWorkflowService,
    UndoRedoService,
    ResultPanelToggleService,
    WorkflowCacheService,
    ValidationWorkflowService,
    WorkflowStatusService,
    WorkflowWebsocketService
  ]
})
export class WorkspaceComponent implements OnInit {

  public showResultPanel: boolean = false;

  constructor(
    private resultPanelToggleService: ResultPanelToggleService,
    // list additional services in constructor so they are initialized even if no one use them directly
    private sourceTablesService: SourceTablesService,
    private schemaPropagationService: SchemaPropagationService,
    private undoRedoService: UndoRedoService,
    private workflowCacheService: WorkflowCacheService,
    private workflowPersistService: WorkflowPersistService,
    private workflowWebsocketService: WorkflowWebsocketService,
    private workflowActionService: WorkflowActionService,
    private route: ActivatedRoute
  ) {
    this.resultPanelToggleService.getToggleChangeStream().subscribe(
      value => this.showResultPanel = value
    );
  }

  ngOnInit(): void {

    if (environment.userSystemEnabled) {
      this.loadWorkflowFromID();
      this.registerWorkflowAutoPersist();
    }
  }

  private loadWorkflowFromID(): void {
    // check if workflow id is present in the url
    if (this.route.snapshot.params.id) {
      this.workflowPersistService.retrieveWorkflow(this.route.snapshot.params.id).subscribe(
        (workflow: Workflow) => {
          this.workflowCacheService.cacheWorkflow(workflow);
          this.workflowCacheService.loadWorkflow();
          this.undoRedoService.clearUndoStack();
          this.undoRedoService.clearRedoStack();
        },
        () => {
          alert('You don\'t have access to this workflow, please log in with another account');
          this.workflowCacheService.resetCachedWorkflow();
          this.workflowCacheService.loadWorkflow();
        }
      );
    }
  }

  private registerWorkflowAutoPersist(): void {
    this.workflowActionService.workflowChange.subscribe(
      () => {
        const cachedWorkflow = this.workflowCacheService.getCachedWorkflow();
        if (cachedWorkflow != null) {
          this.workflowPersistService.persistWorkflow(cachedWorkflow)
            .subscribe((updatedWorkflow: Workflow) => {
              this.workflowCacheService.cacheWorkflow(updatedWorkflow);
            }); // to sync up the updated information, such as workflow.wid
        }
      }
    );
  }
}
