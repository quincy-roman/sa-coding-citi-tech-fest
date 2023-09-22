import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TestPageComponent } from './test-page/test-page.component';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';

const routes: Routes = [
  { path: 'testingStuff', component: TestPageComponent },
  { path: '', component: AppComponent },
  { path: 'login', component: LoginComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
