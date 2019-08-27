import React from "react";
import classNames from "classnames";
import { Manager, Target, Popper } from "react-popper";
import { withRouter } from "react-router-dom";
import {
  withStyles,
  IconButton,
  MenuItem,
  MenuList,
  Grow,
  Paper,
  ClickAwayListener,
  Hidden
} from "material-ui";
import { Person, Notifications, Dashboard, Search } from "material-ui-icons";

import CustomInput from "../CustomInput/CustomInput.jsx";
import SearchButton from "../CustomButtons/IconButton.jsx";

import headerLinksStyle from "../../variables/styles/headerLinksStyle.jsx";

class HeaderLinks extends React.Component {
  constructor(props){
      super(props);
      this.state={
        openMenu: false,
        open: false,
      };
   }

  handleClick = () => {
    this.setState({ open: !this.state.open });
  };

  handleClose = () => {
    this.setState({ open: false });
  };

  handleOpenMenu = () => {
    this.setState({
       openMenu: true,
    });
  };

  handleOnRequestChange = (value) => {
    this.setState({
      openMenu: value,
    });
  };

  onChangeLogout = (event) => {
    event.preventDefault();
    this.props.history.push('/download');
  };

  render() {
    const { classes } = this.props;
    const { open } = this.state;
    return (
      <div>
          <p className='userName classes.top classes.search' style={{float:"left"}}>Seja bem vindo(a) Administrador</p> 
        <Manager style={{ display: "inline-block" }}>
                  <Target>
                    <IconButton
                      color="inherit"
                      aria-label="Person"
                      aria-owns={open ? "menu-list" : null}
                      aria-haspopup="true"
                      onClick={this.handleClick}
                      className={classes.buttonLink}
                    >
                      <Person className={classes.links} />
                    </IconButton>
                  </Target>
                  <Popper
                      placement="bottom-start"
                      eventsEnabled={open}
                      style={{marginLeft: "-120px"}}
                      className={
                        classNames({ [classes.popperClose]: !open }) +
                        " " +
                        classes.pooperResponsive
                      }
                    >
                      <ClickAwayListener onClickAway={this.handleClose}>
                        <Grow
                          in={open}
                          id="menu-list"
                          style={{ transformOrigin: "0 0 0" }}
                        >
                          <Paper className={classes.dropdown}>
                            <MenuList role="menu">
                            <MenuItem
                              onClick={event => this.onChangeLogout(event)}
                              className={classes.dropdownItem}
                            >
                              Meu Cadastro
                            </MenuItem>
                              <MenuItem
                                onClick={event => this.onChangeLogout(event)}
                                className={classes.dropdownItem}
                              >
                                Sair com Segurança
                              </MenuItem>
                            </MenuList>
                          </Paper>
                        </Grow>
                      </ClickAwayListener>
                  </Popper>
                </Manager>

      </div>
    );
  }
}

export default withRouter(withStyles(headerLinksStyle)(HeaderLinks));
