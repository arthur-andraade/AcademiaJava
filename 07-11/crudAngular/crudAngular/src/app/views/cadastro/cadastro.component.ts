import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Pessoa } from 'src/app/model/pessoa';
import { PessoaService } from 'src/app/service/pessoa.service';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css']
})
export class CadastroComponent implements OnInit {

  constructor(private pessoaService: PessoaService, private router: Router) { }

  ngOnInit(): void {
  }

  cadastrarNovaPessoa(pessoa: Pessoa) {
    console.log(pessoa);
    this.pessoaService.cadastrarPessoa(pessoa).subscribe(() => {
      this.router.navigate([""])
    });
  }

}
