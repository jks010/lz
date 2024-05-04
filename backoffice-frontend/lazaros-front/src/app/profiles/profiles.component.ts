import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { UserService } from '../services/user.service';
import {MatTableDataSource} from '@angular/material/table';
import { ProfileService } from '../services/profile.service';
import { ActivatedRoute } from '@angular/router';
import { MatDialog} from '@angular/material/dialog';
import { ProfileOperationsComponent } from '../profile-operations/profile-operations.component';

@Component({
  selector: 'app-profiles',
  templateUrl: './profiles.component.html',
  styleUrl: './profiles.component.css'
})
export class ProfilesComponent {
  form: FormGroup;
  userId: number = 1;


  constructor(private fb: FormBuilder, 
    private profileService: ProfileService,
    private activatedRoute: ActivatedRoute,
    private dialog: MatDialog
    ){
    this.form = this.fb.group({
      name: '',
      description: ''
    })


  }
  openProfileOperations(){
    const refDialog = this.dialog.open(ProfileOperationsComponent, {data: {userId: this.userId, data: null}});
    refDialog.afterClosed().subscribe({
      next: (val) =>{
        if(val){
          this.getUserList();
        }
      }
    })
  }

  displayedColumns: string[] = ['id', 'description', 'action'];
  
  dataSource!: MatTableDataSource<any>;

  ngOnInit(): void{
    
    this.getUserList();
  }

  getUserList(){
    this.activatedRoute.params.subscribe(params => {
      this.userId = params['userId'];
      console.log(params['userId']);
   });
    

    
    if(this.userId==null){
      return;
    }
    this.profileService.getUser(this.userId).subscribe({
      next: (res: any) => {
        this.dataSource = new MatTableDataSource(res);
      }
    })
    
  }


  onFormSubmit(){
    
    
    if(this.form.valid){
      let sendForm = {user: {name: this.form.value.name}, userProfile: {description: this.form.value.description} }
      this.profileService.addProfile(sendForm).subscribe({
        next: (res: any) => {
          alert("Usuário adicionado com sucesso!")
          
        }
      , error: console.log})
    }
  }

  editProfile(dataProfile: any){
    const refDialog = this.dialog.open(ProfileOperationsComponent, {data: {userId: this.userId, data: dataProfile} });
    refDialog.afterClosed().subscribe({
      next: (val) =>{
        if(val){
          this.getUserList();
        }
      }
    })
  }

  delete(id: number){
    this.profileService.deleteUser(id).subscribe({
      next: (res: any) => {
        alert("Usuário deletado com sucesso!")
        this.getUserList()
      },
      error: (err)=> {alert("Erro ao deletar usuário")}
    })
    
  }
}
