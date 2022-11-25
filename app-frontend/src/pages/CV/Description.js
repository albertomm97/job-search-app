import React from 'react';
import Button from 'react-bootstrap/Button';

import { Link } from 'wouter';

const Description = ({ data }) => {
  if (!data.description) {
    return <></>;
  }

  const parragraphs = data.description.split('</br>');

  return (
    <div className="cvPart column">
      <div className="cvPartHeader">
        <h5>CV Text</h5>
        <Link to="/cv/edit-description">
          <Button variant="outline-primary" className="companyButton">
            Edit
          </Button>
        </Link>
      </div>
      <div className="experiences">
        {parragraphs.map((p) => (
          <p key={p}>{p}</p>
        ))}
      </div>
    </div>
  );
};

export default Description;
