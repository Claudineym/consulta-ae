import React from "react";
import { NavLink } from "react-router-dom";
import {
  withStyles,
  Hidden,
  List,
  ListItem,
  ListItemIcon,
  ListItemText
} from "material-ui";
import sidebarStyle from "../../variables/styles/sidebarStyle.jsx";

class ItemMenu extends React.Component {

  constructor(props){
    super(props);
  }

  render() {
  const { classes, route, label, icon } = this.props;
    return(
      <div>
        <NavLink to={route} className={classes.item} activeClassName="active" >
          <ListItem button className={classes.nested}>
            <ListItemIcon className={classes.itemIcon + " " + classes.whiteFont}><this.props.icon /></ListItemIcon>
            <ListItemText inset primary={label} disableTypography={true} className={classes.itemText + " " + classes.whiteFont} />
          </ListItem>
        </NavLink>
      </div>
    );
  };

}
export default withStyles(sidebarStyle)(ItemMenu);
