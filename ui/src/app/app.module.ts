import { NgModule, isDevMode } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { ServiceWorkerModule } from '@angular/service-worker';
import { TestPageComponent } from './test-page/test-page.component';
import { RegisterComponent } from './register/register.component';
import { FormsModule } from '@angular/forms';
import { InProgressComponent } from './in-progress/in-progress.component';
import { HomeComponent } from './home/home.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { AsideComponent } from './components/aside/aside.component';
import { GreetingComponent } from './components/greeting/greeting.component';
import { GradeComponent } from './components/grade/grade.component';
import { AssignmentComponent } from './components/assignment/assignment.component';
import { FooterComponent } from './components/footer/footer.component';
import { ClassesComponent } from './classes/classes.component';
import { FacilitatorHomeComponent } from './components/facilitator-home/facilitator-home.component';
import { BoxComponent } from './components/box/box.component';
import { CalendarComponent } from './calendar/calendar.component';
import { ScChatComponent } from './sc-chat/sc-chat.component';
import { TableComponent } from './components/table/table.component';
import { Box2Component } from './components/box2/box2.component';
import { MainComponent } from './components/main/main.component';
import { UploadComponent } from './components/upload/upload.component';
import { Table2Component } from './components/table2/table2.component';
import { CredentialsService } from './services/credentials.service';
import { AssigmentsComponent } from './assigments/assigments.component';
import { MaterialsComponent } from './materials/materials.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    TestPageComponent,
    RegisterComponent,
    InProgressComponent,
    NavbarComponent,
    AsideComponent,
    HomeComponent,
    GreetingComponent,
    GradeComponent,
    AssignmentComponent,
    FooterComponent,
    ClassesComponent,
    FacilitatorHomeComponent,
    BoxComponent,
    CalendarComponent,
    ScChatComponent,
    TableComponent,
    Box2Component,
    MainComponent,
    UploadComponent,
    Table2Component,
    AssigmentsComponent,
    MaterialsComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ServiceWorkerModule.register('ngsw-worker.js', {
      enabled: !isDevMode(),
      // Register the ServiceWorker as soon as the application is stable
      // or after 30 seconds (whichever comes first).
      registrationStrategy: 'registerWhenStable:30000'
    })
  ],
  providers: [CredentialsService, {provide: HTTP_INTERCEPTORS, useClass: CredentialsService, multi: true}],
  bootstrap: [AppComponent]
})
export class AppModule { }