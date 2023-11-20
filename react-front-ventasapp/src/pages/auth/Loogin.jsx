import React, { useState , useEffect } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import login from '../../styles/login.css';

const Login = () => {
  const navigate = useNavigate();
  const [userName, setuserName] = useState("");
  const [password, setPassword] = useState("");
  const [registerMode, setRegisterMode] = useState(false);
 

  const handleLogin = async (e) => {
    e.preventDefault();

    try {
      const response = await axios.post("http://localhost:8080/auth/login", {
        userName: userName,
        password: password,
      });

      // Procesar la respuesta del backend, por ejemplo, guardar el token en el almacenamiento local
      const token = response.data.token;
      console.log("Guardado exitoso");
      console.log("token:", token);

      // Almacenar el token en el almacenamiento local
      localStorage.setItem("token", token);

      // Redirigir a la página principal o hacer alguna otra acción
      navigate("/dashboard");
    } catch (error) {
      console.error(error);
      // Mostrar un mensaje de error o realizar alguna otra acción
    }
  };

  const handleRegister = async (e) => {
    e.preventDefault();
  
    try {
      const response = await axios.post("http://localhost:8080/auth/create", {
        userName: userName,
        password: password,
      
      });
  
      // Procesar la respuesta del backend, por ejemplo, mostrar un mensaje de éxito
      console.log("Registro exitoso");
      console.log(response);
      // ...
  
      // Llamar a la función handleLogin para iniciar sesión automáticamente
      await handleLogin(e);
  
      // Cambiar al modo de inicio de sesión después del registro
      setRegisterMode(false);
    } catch (error) {
      console.error(error);
      // Mostrar un mensaje de error o realizar alguna otra acción
    }
  };

  useEffect(() => {
    const iniciarSesionBtn = document.getElementById("btn__iniciar-sesion");
    const registerBtn = document.getElementById("btn__registrarse");

    iniciarSesionBtn.addEventListener("click", iniciarSesion);
    registerBtn.addEventListener("click", register);

    return () => {
      iniciarSesionBtn.removeEventListener("click", iniciarSesion);
      registerBtn.removeEventListener("click", register);
    };
  }, []);


  const anchoPage = () => {
    const caja_trasera_register = document.querySelector(".caja__trasera-register");
    const caja_trasera_login = document.querySelector(".caja__trasera-login");
    const formulario_login = document.querySelector(".formulario__login");
    const formulario_register = document.querySelector(".formulario__register");
    const contenedor_login_register = document.querySelector(".contenedor__login-register");

    if (window.innerWidth > 850) {
      caja_trasera_register.style.display = "block";
      caja_trasera_login.style.display = "block";
    } else {
      caja_trasera_register.style.display = "block";
      caja_trasera_register.style.opacity = "1";
      caja_trasera_login.style.display = "none";
      formulario_login.style.display = "block";
      contenedor_login_register.style.left = "0px";
      formulario_register.style.display = "none";
    }
  };

  const iniciarSesion = () => {
    const caja_trasera_register = document.querySelector(".caja__trasera-register");
    const caja_trasera_login = document.querySelector(".caja__trasera-login");
    const formulario_login = document.querySelector(".formulario__login");
    const formulario_register = document.querySelector(".formulario__register");
    const contenedor_login_register = document.querySelector(".contenedor__login-register");

    if (window.innerWidth > 850) {
      formulario_login.style.display = "block";
      contenedor_login_register.style.left = "10px";
      formulario_register.style.display = "none";
      caja_trasera_register.style.opacity = "1";
      caja_trasera_login.style.opacity = "0";
    } else {
      formulario_login.style.display = "block";
      contenedor_login_register.style.left = "0px";
      formulario_register.style.display = "none";
      caja_trasera_register.style.display = "block";
      caja_trasera_login.style.display = "none";
    }
  };

  const register = () => {
    const caja_trasera_register = document.querySelector(".caja__trasera-register");
    const caja_trasera_login = document.querySelector(".caja__trasera-login");
    const formulario_login = document.querySelector(".formulario__login");
    const formulario_register = document.querySelector(".formulario__register");
    const contenedor_login_register = document.querySelector(".contenedor__login-register");

    if (window.innerWidth > 850) {
      formulario_register.style.display = "block";
      contenedor_login_register.style.left = "410px";
      formulario_login.style.display = "none";
      caja_trasera_register.style.opacity = "0";
      caja_trasera_login.style.opacity = "1";
    } else {
      formulario_register.style.display = "block";
      contenedor_login_register.style.left = "0px";
      formulario_login.style.display = "none";
      caja_trasera_register.style.display = "none";
      caja_trasera_login.style.display = "block";
      caja_trasera_login.style.opacity = "1";
    }
  };

  return (
    <div className="bodyy">
      <div className="mainn">
        <div className="contenedor__todo">
          <div className="caja__trasera">
            <div className="caja__trasera-login">
              <h3>¿Ya tienes una cuenta?</h3>
              <p>Inicia sesión para entrar en la página</p>
              <button id="btn__iniciar-sesion">Iniciar Sesión</button>
              <a href="">Olvidé mi contraseña</a>
            </div>
            <div className="caja__trasera-register">
              <h3>¿Aún no tienes una cuenta?</h3>
              <p>Regístrate para poder iniciar sesión</p>
              <button id="btn__registrarse">Registrarse</button>
            </div>
          </div>

          <div className="contenedor__login-register">
            <form onSubmit={handleLogin} className="formulario__login">
              <h2>Iniciar Sesión</h2>
              <input
                type="text"
                id="userName"
                name="userName"
                value={userName}
                onChange={(e) => setuserName(e.target.value)}
                required
                autoFocus
                placeholder="Correo Electrónico"
              />
              <input
                type="password"
                id="password"
                name="password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                required
                autoComplete="current-password"
                placeholder="Contraseña"
              />
              <div className="ad block mt-4">
                <label htmlFor="remember_me" className="flex items-center">
                  <input
                    type="checkbox"
                    id="remember_me"
                    style={{ width: "10px", marginTop: "-1px" }}
                    name="remember"
                  />
                  <span style={{ paddingLeft: "5px", display: "flex" }} className="ml-2 text-sm text-gray-600">
                    Recuérdame
                  </span>
                </label>
              </div>
              <button type="submit">Entrar</button>
            </form>

            <form onSubmit={handleRegister} className="formulario__register">
              <h2>Registrarse</h2>
              <input
                type="text"
                id="userName"
                name="userName"
                value={userName}
                onChange={(e) => setuserName(e.target.value)}
                required
                placeholder="Correo Electrónico"
              />
              <input
                type="password"
                id="password"
                name="password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                required
                autoComplete="new-password"
                placeholder="Contraseña"
              />
             
           
              <button type="submit">Registrarse</button>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Login;