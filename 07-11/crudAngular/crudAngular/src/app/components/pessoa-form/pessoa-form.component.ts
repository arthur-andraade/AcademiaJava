import { Component, EventEmitter, Input, OnInit, Output, OnChanges, SimpleChanges } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Pessoa } from 'src/app/model/pessoa';

@Component({
  selector: 'app-pessoa-form',
  templateUrl: './pessoa-form.component.html',
  styleUrls: ['./pessoa-form.component.css']
})
export class PessoaFormComponent implements OnInit, OnChanges {

  @Input()
  pessoaModel: Pessoa = {
    id: 0,
    nome: "",
    idade: 0,
    profissao: ""
  }

  @Output()
  pessoaChange: EventEmitter<Pessoa> = new EventEmitter<Pessoa>();

  pessoaForm = new FormGroup({
    nome: new FormControl(this.pessoaModel.nome),
    idade: new FormControl(this.pessoaModel.idade),
    profissao: new FormControl(this.pessoaModel.profissao)
  })

  constructor() { }

  ngOnChanges(changes: SimpleChanges): void {
    console.log(changes)
    this.pessoaForm.setValue({
      nome: this.pessoaModel.nome,
      idade: this.pessoaModel.idade,
      profissao: this.pessoaModel.profissao
    })
  }

  ngOnInit(): void {
  }

  alterarModel() {
    this.pessoaModel = this.buildPessoaModel();
    this.pessoaChange.emit(this.pessoaModel);
  }

  private buildPessoaModel(): Pessoa {
    return {
      id: this.pessoaModel.id,
      nome: !this.pessoaForm.value.nome ? "" : this.pessoaForm.value.nome,
      idade: !this.pessoaForm.value.idade ? 0 : Number(this.pessoaForm.value.idade),
      profissao: !this.pessoaForm.value.profissao ? "" : this.pessoaForm.value.profissao,
    }
  }

}
