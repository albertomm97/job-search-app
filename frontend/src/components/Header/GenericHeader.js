import React from 'react';

import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import Button from 'react-bootstrap/Button';

import { Link } from 'wouter';

const UserHeader = () => {
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
  );
};

export default UserHeader;
