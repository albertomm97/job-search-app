import React from 'react';

import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import Button from 'react-bootstrap/Button';

import { Link } from 'wouter';

const UserHeader = ({ logout }) => {
  return (
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

            <Link to="/my-offers">
              <Nav.Link>My Offers</Nav.Link>
            </Link>
          </Nav>

          <Nav>
            <Nav.Link>
              <Button
                className="candidateButton"
                variant="primary"
                onClick={logout}
              >
                LOGOUT
              </Button>
            </Nav.Link>
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
};

export default UserHeader;
