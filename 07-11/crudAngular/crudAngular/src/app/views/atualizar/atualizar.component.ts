import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Pessoa } from 'src/app/model/pessoa';
import { PessoaService } from 'src/app/service/pessoa.service';

@Component({
  selector: 'app-atualizar',
  templateUrl: './atualizar.component.html',
  styleUrls: ['./atualizar.component.css']
})
export class AtualizarComponent implements OnInit {

  pessoaModel: Pessoa = {
    nome: "",
    idade: 0,
    profissao: ""
  }

  constructor(private router: Router, private routeActive: ActivatedRoute, private pessoaService: PessoaService) {
    this.routeActive.params.subscribe(parametros => {
      let pessoaId = parametros['id'];

      pessoaService.buscarPessoa(pessoaId).subscribe((data: Pessoa) => {
        console.log(data);
        this.pessoaModel = data;
      })

    })
  }

  ngOnInit(): void {
  }

  updatePessoa(pessoa: Pessoa) {
    return this.pessoaService.updatePessoa(pessoa).subscribe(()=>{
      this.voltarPaginaListar();
    })
  }

  voltarPaginaListar() {
    this.router.navigate(["/listar"])
  }

  
}
