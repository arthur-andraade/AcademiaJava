import { Component, OnInit } from '@angular/core';
import { Pessoa } from 'src/app/model/pessoa';
import { PessoaService } from 'src/app/service/pessoa.service';

@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.css']
})
export class ListarComponent implements OnInit {

  pessoas: Pessoa[];

  constructor(private pessoaService: PessoaService) { 
    this.pessoas = [];
    this.pessoaService.listarPessoas().subscribe((data: Pessoa[])=> {
      this.pessoas = data
    })
  }

  ngOnInit(): void {
  }

}
