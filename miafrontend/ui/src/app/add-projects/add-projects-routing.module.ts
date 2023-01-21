import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AddProjectsPage } from './add-projects.page';

const routes: Routes = [
  {
    path: '',
    component: AddProjectsPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class AddProjectsPageRoutingModule {
}
