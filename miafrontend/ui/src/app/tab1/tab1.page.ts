import { Component } from '@angular/core';
import { ProjectService } from '../shared/service/project.service';

@Component({
  selector: 'app-tab1',
  templateUrl: 'tab1.page.html',
  styleUrls: ['tab1.page.scss']
})
export class Tab1Page {

  Projects: any = [];

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
  deleteSong(project, i) {
    if (window.confirm('Do you want to delete user?')) {
      this.Projects.deleteSong(project._id)
        .subscribe(() => {
            this.Projects.splice(i, 1);
            console.log('Song deleted!');
          }
        );
    }
  }

}
