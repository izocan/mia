import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { IonicModule } from '@ionic/angular';

import { EditProjectsPageRoutingModule } from './edit-projects-routing.module';

import { EditProjectsPage } from './edit-projects.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    EditProjectsPageRoutingModule,
    ReactiveFormsModule
  ],
  declarations: [EditProjectsPage]
})
export class EditProjectsPageModule {
}
