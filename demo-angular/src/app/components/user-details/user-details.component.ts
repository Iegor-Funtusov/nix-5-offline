import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { ActivatedRoute } from '@angular/router';

import { UserModel } from '../../model/user-model';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.scss']
})
export class UserDetailsComponent implements OnInit {

  userDetails: Observable<UserModel>;
  dateFormat = 'dd.MM.yy HH:mm:ss';

  constructor(private route: ActivatedRoute, private userService: UserService) {
    const routeParams = this.route.snapshot.paramMap;
    const id = Number(routeParams.get('id'));
    this.userDetails = this.userService.findById(id);
  }

  ngOnInit(): void {
  }

}
