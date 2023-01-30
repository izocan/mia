import { Component, OnInit } from '@angular/core';
import { ProjectService } from '../shared/service/project.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, FormGroup } from '@angular/forms';


@Component({
  selector: 'app-edit-projects',
  templateUrl: './edit-projects.page.html',
  styleUrls: ['./edit-projects.page.scss'],
})
export class EditProjectsPage implements OnInit {

  //@ts-ignore
  updateProjectForm: FormGroup;

  id: any;

  constructor(
    private projectService: ProjectService,
    private actRoute: ActivatedRoute,
    private router: Router,
    public fb: FormBuilder
  ) {
    console.log("paramMap: "+ this.actRoute.paramMap);
    console.log("paramMap: "+ this.actRoute.snapshot.paramMap.get('projectid'));
    this.id = this.actRoute.snapshot.paramMap.get('projectid');

  }

  ngOnInit() {
    console.log("Received projectid = " + this.id)
    this.getProjectData(this.id);
    this.updateProjectForm = this.fb.group({
      name: ['testname'],
      address: ['testname']
    });
  }

  getProjectData(id: any) {
    this.projectService.getProject(id).subscribe(res => {
      this.updateProjectForm.setValue({
        // @ts-ignore
        name: res['name'],
        // @ts-ignore
        address: res['address']
      });
    });
  }

  // @ts-ignore
  updateForm() {
    if (!this.updateProjectForm.valid) {
      return false;
    } else {
      this.projectService.updateProject(this.id, this.updateProjectForm.value)
        .subscribe((res) => {
          console.log(res);
          this.updateProjectForm.reset();
          this.router.navigate(['/tabs/tab1']);
        });
    }
  }

}
