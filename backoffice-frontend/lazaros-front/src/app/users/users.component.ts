import { Component } from '@angular/core';
import { MatDialog} from '@angular/material/dialog';
import { UserOperationsComponent } from '../user-operations/user-operations.component';
import { UserService } from '../services/user.service';
import {MatTableDataSource} from '@angular/material/table';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrl: './users.component.css'
})
export class UsersComponent {
  displayedColumns: string[] = ['id', 'name', 'action', 'actionProfile'];
  
  
  
  dataSource!: MatTableDataSource<any>;

  constructor(private dialog: MatDialog, private userService: UserService) {}
  openUserOperations(){
    const refDialog = this.dialog.open(UserOperationsComponent);
    refDialog.afterClosed().subscribe({
      next: (val) =>{
        if(val){
          this.getUserList();
        }
      }
    })
  }

  ngOnInit(): void{
    this.getUserList();
  }

  getUserList(){
    this.userService.getUser().subscribe({
      next: (res: any) => {
        this.dataSource = new MatTableDataSource(res);
      }
    })
    
  }

  editUserOperations(data: any){
    const refDialog = this.dialog.open(UserOperationsComponent, {data: data});
    refDialog.afterClosed().subscribe({
      next: (val) =>{
        if(val){
          this.getUserList();
        }
      }
    })
  }

  deleteUser(id: number){
    this.userService.deleteUser(id).subscribe({
      next: (res: any) => {
        alert("Usuário deletado com sucesso!")
        this.getUserList()
      },
      error: console.log
    })
    
  }
}
