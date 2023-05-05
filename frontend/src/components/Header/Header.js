import React from 'react';

import { useUser } from '../../hooks/useUser';
import UserHeader from './UserHeader';
import CompanyHeader from './CompanyHeader';
import GenericHeader from './GenericHeader';

const Header = () => {
  const { isLogged, type, logout } = useUser();

  console.log(isLogged);
  console.log(type);
  return (
    <header className="App-header">
      {isLogged ? (
        type === 'user' ? (
          <UserHeader logout={logout} />
        ) : (
          <CompanyHeader logout={logout} />
        )
      ) : (
        <GenericHeader />
      )}
    </header>
  );

  /*
  return (
    <header className="App-header">
      <Navbar bg="white" expand="lg">
        <Container>
          <Link to="/">
            <Navbar.Brand>JobSearch</Navbar.Brand>
          </Link>
          <Navbar.Toggle aria-controls="basic-navbar-nav" />
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="me-auto">
              <Link to="/">
                <Nav.Link>Explore Jobs</Nav.Link>
              </Link>
              <Link to="/cv">
                <Nav.Link>CV</Nav.Link>
              </Link>
              <Link to="/company">
                <Nav.Link>Company Details</Nav.Link>
              </Link>
            </Nav>
            <Nav>
              <Link to="/company-login">
                <Nav.Link>
                  <Button className="companyButton" variant="outline-primary">
                    COMPANY ACCESS
                  </Button>
                </Nav.Link>
              </Link>
              <Link to="/candidate-login">
                <Nav.Link>
                  <Button className="candidateButton" variant="primary">
                    CANDIDATE ACCESS
                  </Button>
                </Nav.Link>
              </Link>
            </Nav>
          </Navbar.Collapse>
        </Container>
      </Navbar>
    </header>
  );
  */
};

export default Header;
