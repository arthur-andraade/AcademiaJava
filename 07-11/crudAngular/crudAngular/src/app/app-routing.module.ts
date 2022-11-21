import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AtualizarComponent } from './views/atualizar/atualizar.component';
import { CadastroComponent } from './views/cadastro/cadastro.component';
import { DeletarComponent } from './views/deletar/deletar.component';
import { InicioComponent } from './views/inicio/inicio.component';
import { ListarComponent } from './views/listar/listar.component';

const routes: Routes = [
  { path: "", component: InicioComponent },
  { path: "listar", component: ListarComponent },
  { path: "cadastro", component: CadastroComponent },
  { path: "listar/deletar/:id", component: DeletarComponent },
  { path: "listar/atualizar/:id", component: AtualizarComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
