import React from 'react';
import axios from 'axios';

function pretendRegisterRequest(username, password, cb) {
  console.log(`pretendRegisterRequest: ${username}:${password}`);
  
}

function pretendRequest(username, password, cb) {
  console.log(`pretendREquest: ${username}:${password}`);
  
  var apiBaseUrl = "http://localhost:8080/ConsultaAE/auth";
  
  var url = 'j_username=' + username + '&j_password=' + password;  
          
  axios.post(apiBaseUrl, url)
  .then((response) => {
      if (!response.data.token) {
          if(response.data.flag == 'USER'){
              this.setState({ msgError: {user: response.data.message}, });                   
          } else if (response.data.flag == 'PASSWORD'){
              this.setState({ msgError: {password: response.data.message}, });  
          } else if (response.data.flag == 'DADOS_ERRADOS'){
              this.handleOpen();
              this.setState({ msgError: {dados: response.data.message}, });   
          }
      } else {//Authenticate
          this.setState({ msgError: '' });
          localStorage.token = response.token
          localStorage.name = username;
      }                      
  }).catch(function (error) {
      console.log(error);
     
  });

}

export default {
  login(username, pass, cb) {
    cb = arguments[arguments.length - 1]
    if (localStorage.token) {
      if (cb) cb(true)
      this.onChange(true)
      return
    }

    if (!username || !pass) {
      if (cb) cb(false)
      this.onChange(false)
      return 
    }

    pretendRequest(username, pass, (res) => {
      if (res.authenticated) {
        localStorage.token = res.token
        localStorage.name = username;
        if (cb) cb(true, res.message)
        this.onChange(true)
      } else {
        if (cb) cb(false, res.message)
        this.onChange(false)
      }
    })
  },

  register(username, pass, cb) {
    cb = arguments[arguments.length - 1]

    if (!username || !pass) {
      if (cb) cb(false, `Введите логин и пароль`)
      this.onChange(false)
      return 
    }

    pretendRegisterRequest(username, pass, (res) => {
      if (res.authenticated) {
        localStorage.token = res.token
        localStorage.name = username;
        if (cb) cb(true, res.message)
        this.onChange(true)
      } else {
        if (cb) cb(false, res.message)
        this.onChange(false)
      }
    })
  },

  getToken() {
    return localStorage.token
  },

  getName() {
    return localStorage.name
  },

  logout() {
    delete localStorage.token
    delete localStorage.name
    this.onChange(false)
  },

  loggedIn() {
	  return !!localStorage.token
  },

  onChange() {}
};