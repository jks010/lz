import { Component, Inject } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { UserService } from '../services/user.service';
import {MatTableDataSource} from '@angular/material/table';
import { ProfileService } from '../services/profile.service';
import { ActivatedRoute } from '@angular/router';
import { MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog'

@Component({
  selector: 'app-profile-operations',
  templateUrl: './profile-operations.component.html',
  styleUrl: './profile-operations.component.css'
})
export class ProfileOperationsComponent {
  form: FormGroup;
  
  constructor(private fb: FormBuilder, 
    private profileService: ProfileService,
    private activatedRoute: ActivatedRoute,
    private refDialog: MatDialogRef<ProfileOperationsComponent>,
    @Inject(MAT_DIALOG_DATA) private data: any
    ){
    this.form = this.fb.group({
      id: '',
      description: ''
    })

  }

  displayedColumns: string[] = ['id', 'description', 'action'];
  
  dataSource!: MatTableDataSource<any>;

  
  
  ngOnInit(): void{
   console.log(this.activatedRoute)
    this.form.patchValue(this.data.data)
    console.log(this.data)
  }


  onFormSubmit(){
    if(this.form.value.description.length < 5){
      alert("Descrição precisa de ao menos 5 caracteres")
      return;
    }
    if(this.form.valid){
      if(this.data.data){
        
        let sendForm = {id: this.data.data.id, description: this.form.value.description, userId: this.data.userId}

        this.profileService.updateUser(sendForm).subscribe({
          next: (res: any) => {
            alert("Perfil editado com sucesso!")
            this.refDialog.close(true);
          }
        , error: console.log})
      } 
      else{
        let sendForm = {description: this.form.value.description, userId: this.data.userId}

        this.profileService.addProfile(sendForm).subscribe({
          next: (res: any) => {
            alert("Perfil adicionado com sucesso!")
            this.refDialog.close(true);
          }
        , error: console.log})
      }
    }
  }

}
