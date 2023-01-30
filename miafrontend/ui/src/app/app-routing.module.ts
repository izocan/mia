import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    loadChildren: () => import('./tabs/tabs.module').then(m => m.TabsPageModule)
  },
  {
    path: 'add-projects',
    loadChildren: () => import('./add-projects/add-projects.module').then(m => m.AddProjectsPageModule)
  },
  {
    path: 'edit-projects/:projectid',
    loadChildren: () => import('./edit-projects/edit-projects.module').then(m => m.EditProjectsPageModule)
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, {preloadingStrategy: PreloadAllModules})
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
