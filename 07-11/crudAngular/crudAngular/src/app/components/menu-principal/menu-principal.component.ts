import { Component, OnInit } from '@angular/core';

interface Rota {
  titulo: string,
  path: string
}

@Component({
  selector: 'app-menu-principal',
  templateUrl: './menu-principal.component.html',
  styleUrls: ['./menu-principal.component.css']
})
export class MenuPrincipalComponent implements OnInit {

  opcoes: Rota[] = [{ titulo: "Cadastrar", path: "/cadastro" }, { titulo: "Listar", path: "/listar" }];

  constructor() { }

  ngOnInit(): void {
  }

}
