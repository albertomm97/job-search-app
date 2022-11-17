import React from 'react';
import Button from 'react-bootstrap/Button';

const Language = ({ data }) => {
  return (
    <div className="language">
      <div>
        <p>
          <span>{data.language}</span>: <span>{data.level}</span>
        </p>
      </div>
      <div className="experienceButtons">
        <Button variant="outline-success">Edit</Button>
        <Button variant="outline-danger">Delete</Button>
      </div>
    </div>
  );
};

export default Language;
