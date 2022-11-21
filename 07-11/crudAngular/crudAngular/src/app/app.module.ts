import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MenuPrincipalComponent } from './components/menu-principal/menu-principal.component';
import { ListarComponent } from './views/listar/listar.component';
import { InicioComponent } from './views/inicio/inicio.component';
import { CadastroComponent } from './views/cadastro/cadastro.component';
import { HttpClientModule } from "@angular/common/http"
import { ReactiveFormsModule } from '@angular/forms';
import { DeletarComponent } from './views/deletar/deletar.component';
import { PessoaFormComponent } from './components/pessoa-form/pessoa-form.component';
import { AtualizarComponent } from './views/atualizar/atualizar.component';

@NgModule({
  declarations: [
    AppComponent,
    MenuPrincipalComponent,
    ListarComponent,
    InicioComponent,
    CadastroComponent,
    DeletarComponent,
    PessoaFormComponent,
    AtualizarComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
