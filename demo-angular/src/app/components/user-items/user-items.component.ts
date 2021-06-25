import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

import { UserModel } from '../../model/user-model';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-user-items',
  templateUrl: './user-items.component.html',
  styleUrls: ['./user-items.component.scss']
})
export class UserItemsComponent implements OnInit {

  userItems: Observable<UserModel[]>;
  columns: string[] = [ '#', 'id', 'created', 'name', 'email', 'details', 'delete' ];
  dateFormat: string = 'dd.mm.yy hh:mm:ss';

  constructor(private router: Router, private userService: UserService) {
    this.userItems = this.userService.findAll();
  }

  ngOnInit(): void { }

  delete(id: number): void {
    this.userService.delete(id).subscribe(() => {
      this.userItems = this.userService.findAll();
    });
  }

  details(id: number): void {
    this.router.navigateByUrl('/users/' + id);
  }

  create(): void {
    this.router.navigateByUrl('user-new');
  }
}
