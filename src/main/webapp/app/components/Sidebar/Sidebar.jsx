import React from "react";
import PropTypes from "prop-types";
import { NavLink } from "react-router-dom";
import cx from "classnames";
import {
  withStyles,
  Drawer,
  Hidden,
  List,
  ListItem,
  ListItemIcon,
  ListItemText
} from "material-ui";
import ListSubheader from 'material-ui/List/ListSubheader';

import Collapse from 'material-ui/transitions/Collapse';

import ExpansionPanel, {
  ExpansionPanelSummary,
  ExpansionPanelDetails,
} from 'material-ui/ExpansionPanel';
import Typography from 'material-ui/Typography';
import ExpandMoreIcon from 'material-ui-icons/ExpandMore';
import ExpandLess from 'material-ui-icons/ExpandLess';
import ExpandMore from 'material-ui-icons/ExpandMore';
import SendIcon from 'material-ui-icons/Send';

import ItemMenu from '../../components/ItemMenu/ItemMenu.jsx'

import HeaderLinks from "../../components/Header/HeaderLinks.jsx";
import sidebarStyle from "../../variables/styles/sidebarStyle.jsx";

class Sidebar extends React.Component {
  constructor(props) {
      super(props);
  }
  state = {  open: false, openUser: false, openRelatorio: false, };

  handleClick = () => {
      this.setState({ open: !this.state.open });
  };

  handleClickUser = () => {
      this.setState({ openUser: !this.state.openUser });
  };

  handleClickRelatorio = () => {
      this.setState({ openRelatorio: !this.state.openRelatorio });
  };

render() {
const { classes, color, logo, image, logoText, routes } = this.props;

// verifies if routeName is the one active (in browser input)
const activeRoute = (routeName) => {
  return this.props.location.pathname.indexOf(routeName) > -1 ? true : false;
}

var links = (
      <List className={classes.list} component="nav">
          <ItemMenu route='/home' label='Home' icon={SendIcon}/>
          <ItemMenu route='/download' label='Download' icon={SendIcon}/>
      </List>
  );

var linksAdm = (
  <List className={classes.list} component="nav"
          subheader={<ListSubheader component="div" className={classes.whiteFont +"  fontWeight: bold "}>Menu</ListSubheader>}>
          <ListItem button onClick={this.handleClick}  className={classes.whiteFont}>
              <ListItemIcon className={classes.itemIcon + " " + classes.whiteFont}><SendIcon /></ListItemIcon>
              <ListItemText inset primary="Administrador" disableTypography={true} className={classes.itemText + " " + classes.whiteFont} />
              { this.state.open ? <ExpandLess /> : <ExpandMore />}
          </ListItem>
          <Collapse in={this.state.open} timeout="auto" unmountOnExit>
                      <List component="div" disablePadding >
                        <ItemMenu route='/sistema' label='Sistema' icon={SendIcon}/>
                        <ItemMenu route='/download' label='Perfil' icon={SendIcon}/>
                        <ItemMenu route='/download' label='Módulo' icon={SendIcon}/>
                        <ItemMenu route='/download' label='Arquivos' icon={SendIcon}/>
                        <ItemMenu route='/download' label='Novidade' icon={SendIcon}/>
                        <ItemMenu route='/download' label='Parar Sistema' icon={SendIcon}/>
                        <ItemMenu route='/download' label='Tipo Roteiro' icon={SendIcon}/>
                      </List>
        </Collapse>
  </List>
);

var linksUser = (
  <List className={classes.list} component="nav">
          <ListItem button onClick={this.handleClickUser}  className={classes.whiteFont}>
              <ListItemIcon className={classes.itemIcon + " " + classes.whiteFont}><SendIcon /></ListItemIcon>
              <ListItemText inset primary="Usuario" disableTypography={true} className={classes.itemText + " " + classes.whiteFont} />
              { this.state.openUser ? <ExpandLess /> : <ExpandMore />}
          </ListItem>
          <Collapse in={this.state.openUser} timeout="auto" unmountOnExit>
                      <List component="div" disablePadding >
                        <ItemMenu route='/sistema' label='Meu Cadastro' icon={SendIcon}/>
                        <ItemMenu route='/download' label='Cadastro de usuário' icon={SendIcon}/>
                        <ItemMenu route='/download' label='Lista usuário' icon={SendIcon}/>
                      </List>
          </Collapse>
  </List>
);

var linksRelatorio = (
  <List className={classes.list} component="nav">
          <ListItem button onClick={this.handleClickRelatorio}  className={classes.whiteFont}>
              <ListItemIcon className={classes.itemIcon + " " + classes.whiteFont}><SendIcon /></ListItemIcon>
              <ListItemText inset primary="Relatórios" disableTypography={true} className={classes.itemText + " " + classes.whiteFont} />
              { this.state.openRelatorio ? <ExpandLess /> : <ExpandMore />}
          </ListItem>
          <Collapse in={this.state.openRelatorio} timeout="auto" unmountOnExit>
                      <List component="div" disablePadding >
                        <ItemMenu route='/sistema' label='Acessos por UF' icon={SendIcon}/>
                        <ItemMenu route='/download' label='Acessos por período' icon={SendIcon}/>
                        <ItemMenu route='/download' label='Acessos usuário por UF' icon={SendIcon}/>
                        <ItemMenu route='/download' label='Acessos UF por dia' icon={SendIcon}/>
                        <ItemMenu route='/download' label='Acessos por Usuário UF' icon={SendIcon}/>
                        <ItemMenu route='/download' label='Acessos por Usuário Dist. Frequência' icon={SendIcon}/>
                        <ItemMenu route='/download' label='Qtde. Acessos Mensais dos módulos' icon={SendIcon}/>
                        <ItemMenu route='/download' label='Acessos por módulo por usuário' icon={SendIcon}/>
                        <ItemMenu route='/download' label='Qtde. acessos de um módulo' icon={SendIcon}/>
                      </List>
          </Collapse>
  </List>
);

  var brand = (
    <div className={classes.logo}>
      <a href="#" className={classes.logoLink}>
        <div className={classes.logoImage}>
          <img src={logo} alt="logo" className={classes.img} />
        </div>
        <p>{logoText}</p>
      </a>
    </div>
  );

  return (
    <div>
      <Hidden mdUp>
        <Drawer
          variant="temporary"
          anchor="right"
          open={this.props.open}
          classes={{
            paper: classes.drawerPaper
          }}
          onClose={this.props.handleDrawerToggle}
          ModalProps={{
            keepMounted: true // Better open performance on mobile.
          }}
        >
          {brand}
          <div className={classes.sidebarWrapper}>
            {links}
            {linksAdm}
            {linksUser}
            {linksRelatorio}
          </div>
          {image !== undefined ? (<div  className={classes.background} style={{ backgroundImage: "url(" + image + ")" }} />) : null}
        </Drawer>
      </Hidden>
      <Hidden smDown>
        <Drawer
          anchor="left"
          variant="permanent"
          open
          classes={{
            paper: classes.drawerPaper
          }}
        >
          {brand}
          <div className={classes.sidebarWrapper}>
            {links}
            {linksAdm}
            {linksUser}
            {linksRelatorio}
          </div>
          {image !== undefined ? (
            <div
              className={classes.background}
              style={{ backgroundImage: "url(" + image + ")" }}
            />
          ) : null}
        </Drawer>
      </Hidden>
    </div>
  );
}
};

Sidebar.propTypes = {
  classes: PropTypes.object.isRequired
};

export default withStyles(sidebarStyle)(Sidebar);
