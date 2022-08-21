import React, { useEffect, useState } from 'react';
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';
import { Container, Paper, Button } from '@material-ui/core';

const useStyles = makeStyles((theme) => ({
    root: {
        '& > *': {
            margin: theme.spacing(1),

        },
    },

}));

export default function Misdoing() {
    const paperStyle = { padding: '50px 20px', width: 600, margin: "20px auto" }
    const [when, setWhen] = useState('')
    const [where, setWhere] = useState('')
    const [additionalInfo, setAdditionalInfo] = useState('')
    const [description, setDescription] = useState('')
    const [professor_id, setProfessor] = useState('')
    const [student_id, setStudent] = useState('')
    const [filterValue, setFilter] = useState('')
    var matching = [];




    const [misdoing, setMisdoing] = useState([])
    const classes = useStyles();

    const handleClick = (e) => {
        e.preventDefault()
        const misdoing = { when, where, additionalInfo, description, professor_id, student_id }
        console.log(misdoing)
        fetch("http://localhost:8080/misdoing/add", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(misdoing)

        }).then(() => {
            console.log("New Misdoing added")
        })
    }

    const filterProfessorButtonClick = (e) => {
        e.preventDefault()

        misdoing.map(misdoing => {
            if (misdoing.professor_id == filterValue) {
                matching.push(misdoing);
            }
            setMisdoing(matching);
        })
    }
    const filterStudentButtonClick = (e) => {
        e.preventDefault()

        misdoing.map(misdoing => {
            if (misdoing.student_id == filterValue) {
                matching.push(misdoing);
            }
            setMisdoing(matching);
        })
    }

    const showMisd = (e) => {
        fetch("http://localhost:8080/misdoing/getAll",)
            .then(res => res.json())
            .then((result) => {
                setMisdoing(result);
            }
            )
    }

    return (

        <Container>
            <Paper elevation={3} style={paperStyle}>
                <h1 style={{ color: "black" }}>Add Misdoing</h1>

                <form className={classes.root} noValidate autoComplete="off">

                    <TextField id="outlined-basic" label="Misdoing Date" variant="outlined" fullWidth
                        value={when}
                        onChange={(e) => setWhen(e.target.value)}
                    />
                    <TextField id="outlined-basic" label="Where" variant="outlined" fullWidth
                        value={where}
                        onChange={(e) => setWhere(e.target.value)}
                    />
                    <TextField id="outlined-basic" label="Misdoing Description" variant="outlined" fullWidth
                        value={description}
                        onChange={(e) => setDescription(e.target.value)}
                    />
                    <TextField id="outlined-basic" label="Misdoing Additional Info" variant="outlined" fullWidth
                        value={additionalInfo}
                        onChange={(e) => setAdditionalInfo(e.target.value)}
                    />
                    <TextField id="outlined-basic" label="Professor Code" variant="outlined" fullWidth
                        value={professor_id}
                        onChange={(e) => setProfessor(e.target.value)}
                    />
                    <TextField id="outlined-basic" label="Student ID" variant="outlined" fullWidth
                        value={student_id}
                        onChange={(e) => setStudent(e.target.value)}
                    />
                    <Button variant="contained" color="secondary" onClick={handleClick}>
                        Submit
                    </Button>
                </form>

            </Paper>

            <h1>Misdoings</h1>
            <Button id="misButton" onClick={showMisd} variant="contained" color="secondary">
                Show misdoings
            </Button>


            <Container>
                <TextField id="outlined-basic" label="Filter" variant="outlined" fullWidth
                    value={filterValue}
                    onChange={(e) => setFilter(e.target.value)}
                />
                <Button id="filterButtonP" variant="contained" color="secondary" onClick={filterProfessorButtonClick}>
                    Filter By Professor Code
                </Button>
                <Button id="filterButtonS" variant="contained" color="secondary" onClick={filterStudentButtonClick}>
                    Filter By Student Id
                </Button>
            </Container>

            <Paper elevation={3} style={paperStyle}>

                {misdoing.map(misdoing => (
                    <Paper elevation={6} style={{ margin: "10px", padding: "15px", textAlign: "left" }} key={misdoing.where}>
                        description: {misdoing.description}<br />
                        where: {misdoing.where}<br />
                        when: {misdoing.when}<br />
                        professor: {misdoing.professor_id}<br />
                        student: {misdoing.student_id}<br />
                        additional: {misdoing.additional}<br />
                    </Paper>
                ))
                }


            </Paper>



        </Container>
    );
}