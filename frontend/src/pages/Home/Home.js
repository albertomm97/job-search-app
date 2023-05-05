import React, { useState } from 'react';

import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import FilterForm from '../../components/Filters/FilterForm';
import SearchResults from '../SearchResults/SearchResults';
import FormSearch from '../../components/Filters/FormSearch';

const Home = () => {
  return (
    <Container>
      <Row className="searchContainer">
        <Col lg={12}>
          <div className="searchFormContainer">
            <FormSearch />
          </div>
        </Col>
      </Row>
      <Row>
        <Col lg={3}>
          <div className="filtersContainer">
            <FilterForm />
          </div>
        </Col>
        <Col lg={9}>
          <SearchResults />
        </Col>
      </Row>
    </Container>
  );
};

export default Home;
