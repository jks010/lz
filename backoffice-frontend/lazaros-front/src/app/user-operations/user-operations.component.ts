import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { UserService } from '../services/user.service';
import { MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';

@Component({
  selector: 'app-user-operations',
  templateUrl: './user-operations.component.html',
  styleUrl: './user-operations.component.css'
})
export class UserOperationsComponent implements OnInit{
  form: FormGroup;
  editing: boolean = false
  constructor(private fb: FormBuilder, 
    private userService: UserService,
    private refDialog: MatDialogRef<UserOperationsComponent>,
    @Inject(MAT_DIALOG_DATA) private data: any
    ){
    this.form = this.fb.group({
      name: '',
      description: ''
    })

  }

  ngOnInit(): void{
    this.form.patchValue(this.data)
    console.log(this.data)
    if(this.data){
      this.editing = true;
    }
  }


  onFormSubmit(){
    if(this.form.value.name.length<10){
      alert("Nome precisa de ao menos 10 caracteres")
      return;
    }
    else if(!this.editing && this.form.value.description.length<5){
      alert("Descrição precisa de ao menos 5 caracteres")
      return;
    }
    
    if(this.form.valid){
      if(this.data){
        let sendForm = {name: this.form.value.name, id: this.data.id}

        this.userService.updateUser(sendForm).subscribe({
          next: (res: any) => {
            alert("Usuário editado com sucesso!")
            this.refDialog.close(true);
          }
        , error: console.log})
      } 
      else{
      let sendForm = {user: {name: this.form.value.name}, userProfile: {description: this.form.value.description} }

      this.userService.addUser(sendForm).subscribe({
        next: (res: any) => {
          alert("Usuário adicionado com sucesso!")
          this.refDialog.close(true);
        }
      , error: console.log})
    }
    }
  }
}
