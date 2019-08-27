var React = require('react'); // importa a lib react
var reactDOM = require('react-dom'); // importa a lib react-dom
import ReactDOM from 'react-dom';
import { Router, Route, Switch, BrowserRouter } from 'react-router-dom';
import indexRoutes from "./routes/index.jsx";

import "./statics/css/material-dashboard-react.css";

ReactDOM.render(
          <BrowserRouter>
           <Switch>
             {indexRoutes.map((prop, key) => {
               return <Route exact={prop.exact} path={prop.path} component={prop.component} key={key} />;
             })}
           </Switch>
         </BrowserRouter>
        , document.getElementById('app'));
