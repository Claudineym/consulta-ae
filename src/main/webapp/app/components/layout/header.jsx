import React from 'react';
import { Link } from 'react-router-dom'

class Header extends React.Component {
  render() {
    return (
      <header id="header">
        <div className="header-wrap">
          <div className="header">
            <ul id="menu" className="menu">
              <li className="li logo">
                <Link to="/" className="black south" activeClassName="active" title="export-default">
                  <strong><i className="fa fa-bug" aria-hidden="true"></i> export-default
                  </strong>
                </Link>
              </li>
              <li className="li"><Link to="/add" activeClassName="active"><u>Add</u></Link></li>
              <li className="li"><Link to="/tags" activeClassName="active"><u>Tags</u></Link></li>
              <li className="li"><Link to="/dashboard" activeClassName="active"><u>Profile</u></Link></li>
              
              <li title={"You are " + (this.props.loggedIn ? '' : 'not') + " logged in."} className="li right">  
                {this.props.loggedIn ? (

                  <span>&#123;&#123;#IF LOGGED_IN &#125;&#125; Hi, <b>&#123;&#123;{localStorage.name}&#125;&#125;</b> <Link to="/logout"><u>Logout</u></Link> &#123;&#123;/IF&#125;&#125;</span>
                  
                ) : (
                  <span>
                    <Link to="/login" activeClassName="active">Login</Link>
                    <Link to="/signup" activeClassName="active">Sign up</Link>
                  </span>
                )}
              </li>
            </ul>
          </div>
        </div>
      </header>
    );
  }
}

export default Header;