import React from 'react';
import Button from 'react-bootstrap/Button';

import { Link } from 'wouter';

const Language = ({ data }) => {
  return (
    <div className="language">
      <div>
        <p>
          <span>{data.language}</span>: <span>{data.level}</span>
        </p>
      </div>
      <div className="experienceButtons">
        <Link to={`/cv/edit-language/${data.id}`}>
          <Button variant="outline-success">Edit</Button>
        </Link>
        <Button variant="outline-danger">Delete</Button>
      </div>
    </div>
  );
};

export default Language;
