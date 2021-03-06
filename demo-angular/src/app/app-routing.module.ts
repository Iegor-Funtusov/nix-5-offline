import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { UserItemsComponent } from './components/user-items/user-items.component';
import { UserDetailsComponent } from './components/user-details/user-details.component';
import { UserNewComponent } from './components/user-new/user-new.component';

const routes: Routes = [
  {
    path: '', pathMatch: 'full', redirectTo: 'users'
  },
  {
    path: 'users', component: UserItemsComponent
  },
  {
    path: 'users/:id', component: UserDetailsComponent
  },
  {
    path: 'user-new', component: UserNewComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
