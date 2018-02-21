import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TestsOverviewComponent } from './tests-overview/tests-overview.component';
import { TestDetailComponent } from './test-detail/test-detail.component';
import { GroupDetailComponent } from './group-detail/group-detail.component';
import { MetricsViewComponent } from './metrics-view/metrics-view.component';

const routes: Routes = [
  { path: '', component: TestsOverviewComponent },
  { path: 'overview', component: TestsOverviewComponent },
  { path: 'tests/:id', component:  TestDetailComponent},
  { path: 'groups/:groupname', component: GroupDetailComponent},
  { path: 'metrics-view', component: MetricsViewComponent}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
