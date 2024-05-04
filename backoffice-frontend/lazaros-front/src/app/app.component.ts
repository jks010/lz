import { Component } from '@angular/core';
import { MatDialog} from '@angular/material/dialog';
import { UserOperationsComponent } from './user-operations/user-operations.component';
import { UserService } from './services/user.service';
import {MatTableDataSource} from '@angular/material/table';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'lazaros-front';
  displayedColumns: string[] = ['id', 'name', 'action'];
  
  dataSource!: MatTableDataSource<any>;

  constructor(private dialog: MatDialog, private userService: UserService) {}

}
