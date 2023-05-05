import React, { useContext, useState } from 'react';

import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import FilterOfferContext from '../../context/FilterOfferContext';

const FormSearch = () => {
  const [keyword, setKeyword] = useState('');
  const { filter, setFilter } = useContext(FilterOfferContext);

  const handleSearchSubmit = (event) => {
    event.preventDefault();
    setFilter({ ...filter, keyword });
  };

  const handleChange = (event) => {
    setKeyword(event.target.value);
  };

  return (
    <Form className="searchForm" onSubmit={handleSearchSubmit}>
      <Form.Group className="mb-3">
        <Form.Label>What job are you looking for?</Form.Label>
        <Form.Control
          name="keyword"
          type="text"
          placeholder="Enter keyword"
          onChange={handleChange}
          value={keyword}
        />
      </Form.Group>
      <Button variant="primary" type="submit">
        Search
      </Button>
    </Form>
  );
};

export default FormSearch;
