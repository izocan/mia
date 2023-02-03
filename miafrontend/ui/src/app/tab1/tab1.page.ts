import { Component } from '@angular/core';
import { ProjectService } from '../shared/service/project.service';
// @ts-ignore
import { Project } from '../../api/restAPI';

@Component({
  selector: 'app-tab1',
  templateUrl: 'tab1.page.html',
  styleUrls: ['tab1.page.scss']
})
export class Tab1Page {

  Projects: Project = [];

  constructor(private projectService: ProjectService) {
  }

  ngOnInit() {
  }

  ionViewDidEnter() {
    console.log('fetching Projects');
    this.projectService.getProjects().subscribe((res) => {
      console.log(res);
      this.Projects = res;
    });
  }

  // @ts-ignore
  deleteProject(project) {
      const indexOfProject: number = this.Projects.indexOf(project);
      this.Projects.splice(indexOfProject, 1);

      //Todo service erweitern

  }

}
