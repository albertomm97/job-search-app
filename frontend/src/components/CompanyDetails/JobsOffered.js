import React, { useEffect } from 'react';
import Button from 'react-bootstrap/Button';

import Job from './Job';

import { Link } from 'wouter';

const JobsOffered = ({ data }) => {
  return (
    <div className="cvPart column">
      <div className="cvPartHeader">
        <h5>Jobs offered</h5>
        <Link to="/company/add-offer">
          <Button variant="outline-primary" className="companyButton">
            Add
          </Button>
        </Link>
      </div>
      <div className="experiences">
        {data ? data.map((job) => <Job key={job.id} data={job} />) : <></>}
      </div>
    </div>
  );
};

export default JobsOffered;
