import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Pessoa } from 'src/app/model/pessoa';
import { PessoaService } from 'src/app/service/pessoa.service';

@Component({
  selector: 'app-deletar',
  templateUrl: './deletar.component.html',
  styleUrls: ['./deletar.component.css']
})
export class DeletarComponent implements OnInit {
  
  pessoaNome: string = "";
  pessoaId: number = 0;
  
  constructor(private route: Router, private routeActive: ActivatedRoute, private pessoaService: PessoaService) { 
    this.routeActive.params.subscribe(parametros => {
      this.pessoaId = parametros['id'];
      
      pessoaService.buscarPessoa(this.pessoaId).subscribe((data: Pessoa) => {
        this.pessoaNome = data.nome;
      })
      
    })
  }

  ngOnInit(): void {
  }

  excluirPessoa() {
    this.pessoaService.deletarPessoa(this.pessoaId).subscribe(()=> {
      this.route.navigate(["/listar"])
    })
  }

  cancelar() {
   this.route.navigate(["/listar"]);
  }

}
