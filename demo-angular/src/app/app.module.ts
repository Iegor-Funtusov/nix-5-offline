import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserItemsComponent } from './components/user-items/user-items.component';
import { UserDetailsComponent } from './components/user-details/user-details.component';
import { UserNewComponent } from './components/user-new/user-new.component';

@NgModule({
  declarations: [
    AppComponent,
    UserItemsComponent,
    UserDetailsComponent,
    UserNewComponent
  ],
  imports: [
    CommonModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
