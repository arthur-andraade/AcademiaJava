import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Pessoa } from '../model/pessoa';

@Injectable({
  providedIn: 'root'
})
export class PessoaService {

  private readonly URL = "http://localhost:8080/api/pessoa"

  constructor(private httpClient: HttpClient) { };

  listarPessoas(): Observable<Pessoa[]> {
    return this.httpClient.get<Pessoa[]>(this.URL);
  }

  cadastrarPessoa(pessoa: Pessoa) {
    return this.httpClient.post(this.URL, pessoa);
  }

  buscarPessoa(id: number) {
    return this.httpClient.get<Pessoa>(this.URL + `/${id}`);
  }

  deletarPessoa(id: number) {
    return this.httpClient.delete(this.URL + `/${id}`);
  }

  updatePessoa(pessoa: Pessoa) {
    return this.httpClient.put(this.URL, pessoa);
  }
}
