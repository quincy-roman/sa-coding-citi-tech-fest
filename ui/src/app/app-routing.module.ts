import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TestPageComponent } from './test-page/test-page.component';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { InProgressComponent } from './in-progress/in-progress.component';
import { HomeComponent } from './home/home.component';
import { FacilitatorHomeComponent } from './components/facilitator-home/facilitator-home.component';
import { facilitatorsGuard } from './components/guards/facilitators.guard';

const routes: Routes = [
  { path: 'testingStuff', component: TestPageComponent },
  /** This Redirect will need to Change! */
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'wip', component: InProgressComponent },
  { path: 'home', component: HomeComponent },
  {path: 'facilitator-home', component: FacilitatorHomeComponent, canActivate: [facilitatorsGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
