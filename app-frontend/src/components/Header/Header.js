import React from 'react';

import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import Button from 'react-bootstrap/Button';

import { Link } from 'wouter';

const Header = () => {
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
            </Nav>
            <Nav>
              <Nav.Link href="#marica2">
                <Button className="companyButton" variant="outline-primary">
                  COMPANY ACCESS
                </Button>
              </Nav.Link>
              <Nav.Link href="#marica">
                <Button className="candidateButton" variant="primary">
                  CANDIDATE ACCESS
                </Button>
              </Nav.Link>
            </Nav>
          </Navbar.Collapse>
        </Container>
      </Navbar>
    </header>
  );
};

export default Header;
