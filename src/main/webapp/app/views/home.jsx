import React from 'react';
import { NavLink } from 'react-router-dom';
import auth from '../auth';
import util from '../statics/js/util';

import sefcss from '../statics/css/sef.css';

import RegularCard from '../components/Cards/RegularCard.jsx'

class HomePage extends React.Component{

   constructor(props){
        super(props);
        this.state={
            openMenu: false,
        };
  }

  componentDidMount(){
        document.body.className="bodyTotal"
  }

  handleOpenMenu = () => {
      this.setState({
        openMenu: true,
      });
    }

  handleOnRequestChange = (value) => {
      this.setState({
        openMenu: value,
      });
    }

  onChangeLogout(event){
      event.preventDefault();
      this.props.history.push('/ConsultaAE/logout');
  }

  render() {
    return (
      <div>
        <RegularCard
          cardTitle="Bem vindo!"
        />
      </div>
    );
  }
}

export default HomePage;
