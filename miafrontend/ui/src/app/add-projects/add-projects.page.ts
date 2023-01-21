import { Component, NgZone, OnInit } from '@angular/core';
import { ProjectService } from '../shared/service/project.service';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-add-projects',
  templateUrl: './add-projects.page.html',
  styleUrls: ['./add-projects.page.scss'],
})

export class AddProjectsPage implements OnInit {

  // @ts-ignore
  projectForm: FormGroup;

  constructor(
    private projectService: ProjectService,
    private router: Router,
    public fb: FormBuilder,
    private zone: NgZone
  ) {

    this.projectForm = this.fb.group({
      name: [''],
      address: ['']
    });
  }

  ngOnInit() {
  }


  // @ts-ignore
  onFormSubmit() {
    if (!this.projectForm.valid) {
      return false;
    } else {
      this.projectService.addProject(this.projectForm.value)
        .subscribe((res) => {
          this.zone.run(() => {
            console.log(res);
            this.projectForm.reset();
            this.router.navigate(['/tabs/tab1']);
          });
        });
    }
  }

}
